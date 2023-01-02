package com.br.digitalMarketPlace.modules.clients.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IProductsRepository;
import com.br.digitalMarketPlace.shared.exceptions.AppError;
@Service
public class ProductServiceImpl implements IProductService {

	private final IProductsRepository productsRepository;

	public ProductServiceImpl(IProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	

	@Override
	public String createProduct(IProductDTO productDTO) {
		final Product product = new Product();
		product.setId(UUID.randomUUID().toString());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());

		productsRepository.save(product);
		return product.getId();
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAllProducts();
	}

	@Override
	public Product showProduct(String id) {

		return productsRepository.findById(id).orElseThrow(() -> new AppError("product no found"));
	}

	@Override
	public void updateProduct(String id, IProductDTO productDTO) {
		Product product = productsRepository.findById(id).orElseThrow(() -> new AppError("Product no found"));

		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());

		productsRepository.save(product);
	}

	@Override
	public void deleteProduct(String id) {
		Product product = productsRepository.findById(id).orElseThrow(() -> new AppError("Product not found"));

		productsRepository.delete(product);
	}

}
