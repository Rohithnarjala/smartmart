package com.project.productservice.service;

import java.util.Date;
import java.util.List;

import com.project.productservice.exception.OfferAlreadyExistsException;
import com.project.productservice.model.Offer;

public interface OfferService {

	public void addOffer(Offer offer, int id) throws OfferAlreadyExistsException;

	public void updateOffer(Offer offer, int id) throws OfferAlreadyExistsException;

	public Offer getOffer(int id);

	public void deleteOffer(int id);

	public List<Offer> getCurrentOffers();

	public List<Offer> getOffers(Date date);

}
