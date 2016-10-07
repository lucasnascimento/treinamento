/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.interagil.treinamento.service;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Hotel;
import com.interagil.treinamento.validator.CidadeValidator;
import com.interagil.treinamento.validator.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("hotelervice")
@Transactional
class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	HotelValidator hotelValidator;

	@Override
	public Hotel salvar(Hotel hotel) {
		if (!this.hotelValidator.validar(hotel)){
			throw new IllegalArgumentException("Hotel informado invalido.");
		}
		if (hotelRepository.countByNome(hotel.getNome()) != 0){
			throw new IllegalArgumentException("Hotel já cadastrado.");
		}

		return this.hotelRepository.save(hotel);
	}

}
