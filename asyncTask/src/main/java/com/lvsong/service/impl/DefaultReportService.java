package com.lvsong.service.impl;

import com.lvsong.domain.Report;
import com.lvsong.service.ReportService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by lvsong on 7/28/15.
 */
@Service("reportsService")
public class DefaultReportService implements ReportService {
    @Async
    public Future<Report> generateReport() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Report report = new Report();
        report.setName("New Report");
        report.setDesc("New Report Description");

        return new AsyncResult<Report>(report);

    }
}
