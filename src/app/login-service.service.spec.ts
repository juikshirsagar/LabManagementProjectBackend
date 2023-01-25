import { HttpClient ,HttpErrorResponse} from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { LoginServiceService } from './login-service.service';

fdescribe('LoginServiceService', () => {
  let service: LoginServiceService;
  let httpClient: HttpClient;
  let httpController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [LoginServiceService],
    });
    service = TestBed.inject(LoginServiceService);
    httpClient = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);
  });

  it('is created', () => {
    expect(service).toBeDefined();
  });

  
});
