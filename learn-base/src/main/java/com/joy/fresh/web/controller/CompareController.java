package com.joy.fresh.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.joy.fresh.model.CompareInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.joy.fresh.service.CompareInfoService;

/**
 * Created by jianyuanhao on 16-8-18.
 */
@Controller
@RequestMapping("/")
public class CompareController {
    private static final Logger logger = LoggerFactory.getLogger(CompareController.class);
    private static final int pageSize = 2;

    @Autowired
    CompareInfoService compareInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, Model model,
            HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        Integer compareInfoCount = compareInfoService.queryCompareInfoCount();
        String loginName = httpServletRequest.getParameter("userName");
        if (loginName != null) {
            model.addAttribute("userName", loginName);
        }
        model.addAttribute("compareInfoCount", compareInfoCount);

        if (compareInfoCount > 0) {
            List<CompareInfo> compareInfos = compareInfoService.queryCompareInfos(pageNum * pageSize, pageSize);
            model.addAttribute("pageNum", pageNum);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("compareInfos", compareInfos);
        }
        return "home";
    }

    /**
     * 提交对比文件
     *
     * @param source
     * @param target
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping(method = RequestMethod.POST)
    public String uploadFileAction(@RequestPart("source") MultipartFile source,
            @RequestPart("target") MultipartFile target, HttpServletRequest httpServletRequest) throws IOException {
        if (source.isEmpty() || target.isEmpty()) {
            return "redirect:/";
        }
        compareInfoService.saveCompareInfo(source.getInputStream(), target.getInputStream());
        return "redirect:/";
    }

    /**
     * 删除对比结果
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCompareInfo(@PathVariable int id) {
        compareInfoService.deleteCompareInfo(id);
        return "redirect:/";
    }

}
