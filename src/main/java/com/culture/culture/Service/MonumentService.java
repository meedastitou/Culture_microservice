package com.culture.culture.Service;

import java.util.List;

import com.culture.culture.Model.Monument;

import jakarta.validation.Valid;

public interface MonumentService {
	Monument save(@Valid Monument monument);

    List<Monument> getAll();

    Monument getOne(String id);

    void delete(Monument plat);
}
