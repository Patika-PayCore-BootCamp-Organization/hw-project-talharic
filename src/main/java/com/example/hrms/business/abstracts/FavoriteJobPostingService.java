package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.FavoriteJobPosting;
import com.example.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface FavoriteJobPostingService extends BaseEntityService<FavoriteJobPosting> {

    DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId);

    DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId);

    DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId);

}
