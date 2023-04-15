package com.qu.finsys.controllers;

import com.qu.finsys.config.AppConstants;
import com.qu.finsys.payloads.CurrencyDTO;
import com.qu.finsys.payloads.CurrencyResponse;
import com.qu.finsys.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/admin/currency")
    public ResponseEntity<CurrencyResponse> getCurrencies(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_USERS_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {

        CurrencyResponse currencyResponse = currencyService.getAllCurrencies(pageNumber, pageSize, sortBy, sortOrder);

        return new ResponseEntity<CurrencyResponse>(currencyResponse, HttpStatus.OK);
    }

    @GetMapping("/public/currency/{currNo}")
    public ResponseEntity<CurrencyDTO> getCurrency(@PathVariable Long currNo) {
        CurrencyDTO currency = currencyService.getCurrencyById(currNo);

        return new ResponseEntity<CurrencyDTO>(currency, HttpStatus.FOUND);
    }

    @PutMapping("/public/currency/{currNo}")
    public ResponseEntity<CurrencyDTO> updateUser(@RequestBody CurrencyDTO currencyDTO, @PathVariable Long currNo) {
        CurrencyDTO updatedCurrency = currencyService.updateCurrency(currNo, currencyDTO);
        return new ResponseEntity<CurrencyDTO>(updatedCurrency, HttpStatus.OK);
    }

    @DeleteMapping("/admin/currency/{currNo}")
    //@PreAuthorize("users_deleteuser")
    public ResponseEntity<String> deleteCurrency(@PathVariable Long currNo) {
        String status = currencyService.deleteCurrency(currNo);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
