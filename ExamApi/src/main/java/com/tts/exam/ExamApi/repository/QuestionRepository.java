package com.tts.exam.ExamApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tts.exam.ExamApi.model.Question;



public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
