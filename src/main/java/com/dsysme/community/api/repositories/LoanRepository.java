package com.dsysme.community.api.repositories;

import com.dsysme.community.api.models.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, Integer> {

}
