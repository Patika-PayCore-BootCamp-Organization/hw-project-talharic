package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithAllRelatedEntitiesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private CoverLetterService coverLetterService;
    private ImageService imageService;
    private EducationService educationService;
    private ExperienceService experienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, CoverLetterService coverLetterService, ImageService imageService, EducationService educationService, ExperienceService experienceService) {
        this.resumeDao = resumeDao;
        this.coverLetterService = coverLetterService;
        this.imageService = imageService;
        this.educationService = educationService;
        this.experienceService = experienceService;
    }

    @Override
    public Result add(Resume resume) {

        resume.setCreationDate(LocalDateTime.now());

        resumeDao.save(resume);
        return new SuccessResult("Özgeçmiş eklendi.");
    }

    @Override
    public Result update(Resume resume) {

        resumeDao.save(resume);
        return new SuccessResult("Özgeçmiş güncellendi.");
    }

    @Override
    public Result delete(Resume resume) {

        resumeDao.delete(resume);
        return new SuccessResult("Özgeçmiş silindi.");
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(resumeDao.getById(id));
    }

    @Override
    public Result addCoverLetterToResume(int resumeId, int coverLetterId) {

        Resume resume = getById(resumeId).getData();
        resume.setCoverLetter(coverLetterService.getById(coverLetterId).getData());

        update(resume);
        return new SuccessResult("Ön yazı özgeçmişe eklendi.");
    }

    @Override
    public DataResult<Resume> getByCandidateId(int candidateId) {
        return new SuccessDataResult<Resume>(resumeDao.getByCandidate_Id(candidateId));
    }

    @Override
    public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId) {

        Resume resume = getByCandidateId(candidateId).getData();

        ResumeWithAllRelatedEntitiesDto resumeWithAllRelatedEntitiesDto = new ResumeWithAllRelatedEntitiesDto(
                resume.getId(),
                resume.getCreationDate(),
                resume.getCandidate(),
                resume.getCoverLetter(),
                imageService.getByUserId(candidateId).getData(),
                educationService.getAllByResumeIdSortedByGraduationDate(resume.getId()).getData(),
                experienceService.getAllByResumeIdSortedByTerminationDate(resume.getId()).getData(),
                resume.getLanguageLevels(),
                resume.getLinks(),
                resume.getSkills()
        );

        return new SuccessDataResult<ResumeWithAllRelatedEntitiesDto>(resumeWithAllRelatedEntitiesDto);
    }

}