package com.chinmay.bfhl.service;

import com.chinmay.bfhl.dto.RequestDto;
import com.chinmay.bfhl.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlService {

    private static final String USER_ID = "chinmay_neema_20092005";
    private static final String EMAIL = "chinmayneema231019@acropolis.in";
    private static final String ROLL_NUMBER = "0827CS231066";

    public ResponseDto processData(RequestDto request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;

        StringBuilder alphaConcat = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphaConcat.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        String reversed = alphaConcat.reverse().toString();

        StringBuilder concatString = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            if (i % 2 == 0) {
                concatString.append(Character.toUpperCase(reversed.charAt(i)));
            } else {
                concatString.append(Character.toLowerCase(reversed.charAt(i)));
            }
        }

        return new ResponseDto(
                true,
                USER_ID,
                EMAIL,
                ROLL_NUMBER,
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString.toString()
        );
    }
}