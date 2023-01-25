package com.testcase.reportservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.testcase.reportservice.exception.ReportIdAlreadyExistsException;
import com.testcase.reportservice.model.Report;
import com.testcase.reportservice.repository.ReportRepository;
import com.testcase.reportservice.service.ReportService;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ReportServiceApplicationTests {

	
}
