package com.project.productservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.exception.OfferAlreadyExistsException;
import com.project.productservice.model.Offer;
import com.project.productservice.model.Product;
import com.project.productservice.repository.OfferRepository;
import com.project.productservice.repository.ProductRepository;

@Service
public class OfferServiceImpl implements OfferService{

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void addOffer(Offer offer, int id) throws OfferAlreadyExistsException {
		Product product = productRepository.findById(id);
		offer.setProductId(product);
		Optional<Offer> offer2 = offerRepository.getOffer(offer.getOfferDate(), product.getId());
		if(!offer2.isPresent()) {
			offerRepository.save(offer);
		} else {
			throw new OfferAlreadyExistsException();
		}
		
	
		
	}

	@Override
	public void updateOffer(Offer offer, int id) throws OfferAlreadyExistsException {
		Product product = productRepository.findById(id);
		offer.setProductId(product);
		offerRepository.save(offer);
	}

	@Override
	public Offer getOffer(int id) {
		// TODO Auto-generated method stub
		return offerRepository.findById(id).get();
	}

	@Override
	public void deleteOffer(int id) {
		offerRepository.deleteById(id);	
		
	}

	@Override
	public List<Offer> getCurrentOffers() {
		// TODO Auto-generated method stub
		return offerRepository.getCurrentOffer();
	}

	@Override
	public List<Offer> getOffers(Date date) {
		// TODO Auto-generated method stub
		return offerRepository.getOfferList(date);
	}

}
