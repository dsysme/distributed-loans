package com.dsysme.community.api.repositories;

import com.dsysme.community.api.models.Loaner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanerRepository extends PagingAndSortingRepository<Loaner, String> {
}
