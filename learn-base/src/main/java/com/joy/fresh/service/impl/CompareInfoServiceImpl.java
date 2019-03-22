//package com.joy.fresh.service.impl;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.annotation.Resource;
//
//import com.joy.fresh.dao.CompareInfoDao;
//import com.joy.fresh.model.CompareInfo;
//import org.apache.ibatis.session.RowBounds;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//import org.springframework.stereotype.Service;
//
//import com.google.common.base.Charsets;
//import com.google.common.base.Joiner;
//import com.google.common.base.Preconditions;
//import com.google.common.collect.MapDifference;
//import com.google.common.collect.Maps;
//import com.google.common.io.CharStreams;
//import com.joy.fresh.model.CompareInfoBuilder;
//import com.joy.fresh.service.CompareInfoService;
//
///**
// * 功能: 业务 Created by liujiakun on 16-6-18.
// */
//@Service
//public class CompareInfoServiceImpl implements CompareInfoService {
//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//    @Resource
//    CompareInfoDao compareInfoDao;
//
//    @Override
//    public int saveCompareInfo(InputStream sourceStream, InputStream targetStream) throws IOException {
//        // 校验非空
//        Preconditions.checkNotNull(sourceStream);
//        Preconditions.checkNotNull(targetStream);
//        // input流转为字节数组输入流
//        ByteArrayInputStream sBAI = convertToByteArrayStream(sourceStream);
//        ByteArrayInputStream tBAI = convertToByteArrayStream(targetStream);
//
//        Properties spro = new Properties();
//        spro.load(sBAI);
//        Properties tpro = new Properties();
//        tpro.load(tBAI);
//        Map<String, String> sMap = (Map) spro;
//        Map<String, String> tMap = (Map) tpro;
//
//        sBAI.reset();
//        tBAI.reset();
//
//        CompareInfo compareInfo = createCompareInfo(sBAI, tBAI, sMap, tMap);
//
//        sBAI.close();
//        tBAI.close();
//        int count = compareInfoDao.saveCompareInfo(compareInfo);
//        return count;
//    }
//
//    @Override
//    public int queryCompareInfoCount() {
//        return compareInfoDao.queryCompareInfoCount();
//    }
//
//    @Override
//    public List<CompareInfo> queryCompareInfos(int start, int size) {
//        return compareInfoDao.queryCompareInfos(new RowBounds(start, size));
//    }
//
//    @Override
//    public int deleteCompareInfo(Integer id) {
//        return compareInfoDao.deleteCompareInfo(id);
//    }
//
//    private CompareInfo createCompareInfo(ByteArrayInputStream sBAI, ByteArrayInputStream tBAI,
//            Map<String, String> sMap, Map<String, String> tMap) throws IOException {
//        CompareInfo compareInfo = new CompareInfoBuilder().setSourceContext(convertStreamToString(sBAI))
//                .setTargetContext(convertStreamToString(tBAI)).setDiffContext(compareDiff(sMap, tMap))
//                .setCompareTime(new DateTime()).createCompareInfo();
//        return compareInfo;
//    }
//
//    private ByteArrayInputStream convertToByteArrayStream(InputStream inputStream) throws IOException {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        org.apache.commons.io.IOUtils.copy(inputStream, byteArrayOutputStream);
//
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        byteArrayOutputStream.close();
//        return new ByteArrayInputStream(bytes);
//    }
//
//    private String convertStreamToString(ByteArrayInputStream inputStream) throws IOException {
//        return CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8))
//                .replace(System.getProperty("line.separator"), "<br/>");
//    }
//
//    private String compareDiff(final Map<String, String> source, final Map<String, String> target) {
//        StringBuilder stringBuilder = new StringBuilder();
//        MapDifference<String, String> difference = Maps.difference(source, target);
//        // 源存在、目标不存在 => -a2=y
//        if (difference.entriesOnlyOnLeft() != null) {
//            stringBuilder.append("-"
//                    + Joiner.on("<br/>-").withKeyValueSeparator("=").join(difference.entriesOnlyOnLeft()) + "<br/>");
//        }
//        // 源不存在、目标存在 => +a4=n
//        if (difference.entriesOnlyOnRight() != null) {
//            stringBuilder.append("+"
//                    + Joiner.on("<br/>+").withKeyValueSeparator("=").join(difference.entriesOnlyOnRight()) + "<br/>");
//        }
//        // 源和目标存在、但不同 => -a3=z;+a3=x
//        for (Map.Entry<String, MapDifference.ValueDifference<String>> stringValueDifferenceEntry : difference
//                .entriesDiffering().entrySet()) {
//            stringBuilder.append("-" + Joiner.on(";+")
//                    .join(Joiner.on("=").join(stringValueDifferenceEntry.getKey(),
//                            stringValueDifferenceEntry.getValue().leftValue()),
//                            Joiner.on("=").join(stringValueDifferenceEntry.getKey(),
//                                    stringValueDifferenceEntry.getValue().rightValue()))
//                    + "<br/>");
//        }
//        return stringBuilder.toString();
//    }
//
//}
