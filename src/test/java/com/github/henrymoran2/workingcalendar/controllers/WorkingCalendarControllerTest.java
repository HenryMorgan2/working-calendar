package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.converter.WorkingCalendarConverter;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import com.github.henrymoran2.workingcalendar.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WorkingCalendarController.class)
public class WorkingCalendarControllerTest {

    @MockBean
    private WorkingCalendarConverter workingCalendarConverter;
    @MockBean
    private  WorkingCalendarService workingCalendarService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNonWorkingDays_whenRequestParamsIsEmpty_thenReturnBadRequestStatus() throws Exception {

        mockMvc.perform(get("/api/non-working-days")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(FileUtils.getFileAsString("converter/get_converter_ParamsIsEmpty_400.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNonWorkingDays_whenRequestParamsDoesNotMatchType_thenReturnBadRequestStatus() throws Exception {

        mockMvc.perform(get("/api/non-working-days")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(FileUtils.getFileAsString("converter/get_converter_ParamsDoesNotMatchType_400.json"))
                        .param("start", "badParametr1")
                        .param("end", "badParametr2"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNonWorkingDays_whenAllIsOk_thenReturnOkStatus() throws Exception {

        mockMvc.perform(get("/api/non-working-days")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("start", "2023-11-01")
                        .param("end", "2023-11-07")
                        .content(FileUtils.getFileAsString("converter/get_converter_whenAllIsOk_200.json")))
                .andDo(print())
                .andExpect(status().isOk());
    }




}
