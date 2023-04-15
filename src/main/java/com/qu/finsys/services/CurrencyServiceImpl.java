package com.qu.finsys.services;

import com.qu.finsys.entities.GlCurrencies;
import com.qu.finsys.exceptions.APIException;
import com.qu.finsys.exceptions.ResourceNotFoundException;
import com.qu.finsys.payloads.CurrencyDTO;
import com.qu.finsys.payloads.CurrencyResponse;
import com.qu.finsys.repositories.CurrencyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Autowired
    CurrencyRepository currenciesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CurrencyDTO addCurrency(CurrencyDTO currencyDTO) {

        try {
            GlCurrencies glCurrencies = modelMapper.map(currencyDTO, GlCurrencies.class);

            GlCurrencies glCurrenciesNew = currenciesRepository.save(glCurrencies);
            currencyDTO = modelMapper.map(glCurrenciesNew, CurrencyDTO.class);

            return currencyDTO;
        } catch (DataIntegrityViolationException e) {
            throw new APIException("Currency already exists with CurrNO: " + currencyDTO.getCurrAName());
        }

    }

    @Override
    public CurrencyResponse getAllCurrencies(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<GlCurrencies> pageCurrencies = currenciesRepository.findAll(pageDetails);

        List<GlCurrencies> currencies = pageCurrencies.getContent();

        if (currencies.size() == 0) {
            throw new APIException("No Currency exists !!!");
        }

        List<CurrencyDTO> currencyDTOs = currencies.stream().map(currency -> {
            CurrencyDTO dto = modelMapper.map(currency, CurrencyDTO.class);

            return dto;

        }).collect(Collectors.toList());

        CurrencyResponse currencyResponse = new CurrencyResponse();

        currencyResponse.setContent(currencyDTOs);
        currencyResponse.setPageNumber(pageCurrencies.getNumber());
        currencyResponse.setPageSize(pageCurrencies.getSize());
        currencyResponse.setTotalElements(pageCurrencies.getTotalElements());
        currencyResponse.setTotalPages(pageCurrencies.getTotalPages());
        currencyResponse.setLastPage(pageCurrencies.isLast());

        return currencyResponse;
    }

    @Override
    public CurrencyDTO getCurrencyById(Long currNo) {
        GlCurrencies glCurrencies = currenciesRepository.findById(currNo)
                .orElseThrow(() -> new ResourceNotFoundException("GlCurrencies", "currNo", currNo));

        CurrencyDTO currencyDTO = modelMapper.map(glCurrencies, CurrencyDTO.class);
        return currencyDTO;
    }

    @Override
    public CurrencyDTO updateCurrency(Long CurrNo, CurrencyDTO currencyDTO) {
        GlCurrencies glCurrencies = currenciesRepository.findByCurrNo(CurrNo)
                .orElseThrow(() -> new ResourceNotFoundException("glCurrencies", "CurrNo", CurrNo));


        glCurrencies.setCurrAName(currencyDTO.getCurrAName());
        glCurrencies.setCurrEName(currencyDTO.getCurrEName());
        glCurrencies.setCurrPartAName(currencyDTO.getCurrPartAName());
        glCurrencies.setCurrPartEname(currencyDTO.getCurrPartEName());
        glCurrencies.setCurrSign(currencyDTO.getCurrSign());

        currencyDTO = modelMapper.map(glCurrencies, CurrencyDTO.class);
        return currencyDTO;
    }

    @Override
    public String deleteCurrency(Long currNo) {
        GlCurrencies glCurrencies = currenciesRepository.findById(currNo)
                .orElseThrow(() -> new ResourceNotFoundException("GlCurrencies", "currNo", currNo));
        currenciesRepository.delete(glCurrencies);
        return "GlCurrencies with CurrNo " + currNo + " deleted successfully!!!";
    }

}
