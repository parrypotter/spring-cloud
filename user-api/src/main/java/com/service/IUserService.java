package com.service;

import java.util.List;

/**
 * @author parry
 */
public interface IUserService {


    /**
     * getVersion 
     * @param version
     * @return java.lang.String
     * @author 潘锐
    */
    String getVersion(String version);

    /**
     * mergeVersionInfo
     * @param infoList
     * @return java.lang.String
     * @author 潘锐
    */
    String mergeVersionInfo(List<String> infoList);

}
