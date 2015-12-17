package com.lvsong.service;

import com.lvsong.domain.Report;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by lvsong on 7/28/15.
 */
public interface ReportService {
    public Future<Report> generateReport();
}
