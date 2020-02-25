package com.tts.exam.ExamApi.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tts.exam.ExamApi.exception.ResourceNotFoundException;
import com.tts.exam.ExamApi.model.Answer;
import com.tts.exam.ExamApi.repository.AnswerRepository;
import com.tts.exam.ExamApi.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class AnswerController {
	 @Autowired
	AnswerRepository answerReposity;
	 
	 @Autowired
	 ReportService reportService;
	
	@GetMapping("/answer")
	public List<Answer> getAllAnswer(){
		return answerReposity.findAll();
	}
	
	@PostMapping("/answer")
	public Answer createNote(@Valid @RequestBody Answer answer) {
		return answerReposity.save(answer);
	}
	
	@GetMapping("/answer/{id}")
	public Answer getAnswerById(@PathVariable(value="id") Integer answerId) {
		return answerReposity.findById(answerId).orElseThrow(()-> new ResourceNotFoundException("Answer", "id", answerId));
	}

	@PutMapping("/answer/{id}")
	public Answer updateNote(@PathVariable(value="id") Integer answerId, @Valid @RequestBody Answer answerDetails) {
		Answer answer = answerReposity.findById(answerId).orElseThrow(()-> new ResourceNotFoundException("Answer", "id", answerId));
		answer.setAnswername(answerDetails.getAnswername());
		answer.setPostedBy(answerDetails.getPostedBy());
		
		Answer updateAnswer= answerReposity.save(answer);
		return updateAnswer;
		
	}
	@DeleteMapping("/answer/{id}")
	public ResponseEntity<?> deleteAnswer(@PathVariable(value="id") Integer answerId){
		Answer answer = answerReposity.findById(answerId).orElseThrow(()-> new ResourceNotFoundException("Answer", "id", answerId));
		answerReposity.delete(answer);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
	}
}
