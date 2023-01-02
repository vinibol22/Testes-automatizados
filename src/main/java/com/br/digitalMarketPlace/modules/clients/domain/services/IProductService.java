package com.br.digitalMarketPlace.modules.clients.domain.services;

import java.util.List;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;

public interface IProductService {
	String createProduct(IProductDTO product);
	List<Product> listProducts();
	Product showProduct(String id);
	void updateProduct(String id, IProductDTO product);
	void deleteProduct(String id);
}
