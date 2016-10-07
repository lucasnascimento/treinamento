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
import com.interagil.treinamento.validator.CidadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("cityService")
@Transactional
class CidadeServiceImpl implements CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	CidadeValidator cidadeValidator;

	@Override
	public Cidade salvar(Cidade cidade) {
		if (!this.cidadeValidator.validar(cidade)){
			throw new IllegalArgumentException("Cidade informada invalida.");
		}
		if (cidadeRepository.countByNomeAndEstado(cidade.getNome(), cidade.getEstado()) != 0){
			throw new IllegalArgumentException("Cidade já cadastrada.");
		}

		return this.cidadeRepository.save(cidade);
	}

}
