package com.sdu.supportteach.controller;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sdu.supportteach.entity.Picture;
import com.sdu.supportteach.request.PicSaveRequest;
import com.sdu.supportteach.service.PictureService;
import com.sdu.supportteach.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzyu
 * @since 2022-01-15
 */
@RestController
@RequestMapping("/api/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @GetMapping("/get")
    public Result getPicture(){
        System.out.println("获取封面图");
        return Result.success(pictureService.getAll());
    }

    @PostMapping("/save")
    public Result savePicture(@Validated @RequestBody PicSaveRequest picSaveRequest){
        JSONArray pics = picSaveRequest.getPictures();
        for (int i=0; i< pics.size(); ++i){
            JSONObject obj = (JSONObject) pics.get(i);
            if(obj.get("id").toString().equals("0")){
                Picture pic = new Picture();
                pic.setUrl(obj.get("url").toString());
                pictureService.save(pic);
            }else {
                Picture pic = pictureService.getById(obj.get("id").toString());
                pic.setUrl(obj.get("url").toString());
                pictureService.saveOrUpdate(pic);
            }
        }

        return Result.success("success");
    }
}
