<template>
  <div class="title">轮番图</div>
  <el-form class="picform"  label-width="120px">
      <el-form-item v-for="(item, index) in this.pictures" :key="index" label='图片'>
        <el-input v-model="item.url" >
        </el-input>
      </el-form-item>
      <el-form-item label="添加图片">
          <el-input v-model="add.url"></el-input>
      </el-form-item>
      <el-form-item>
          <el-button type="success" @click="savePagePic()">保存信息</el-button>
      </el-form-item>
  </el-form>
</template>

<script>
import { mapState } from 'vuex'
import {getPictures, savePictures} from "../services"
export default {
    data(){
        return {
            pictures: [],
            add: {'id': 0, 'url': ""},
            origin: [],
            sendArray: []
        }
    },
    computed: {
      ...mapState([
        'account', 'jwtToken', 'id'
      ])  
    }, 
    created(){
        this.getPagePic();
    },
    methods:{
        getPagePic(){
            if(this.id==1 && this.jwtToken !="" && this.jwtToken !=null )
                getPictures().then(res =>{
                    if(res.code =="200"){
                        this.pictures = res.data;
                        for (var i=0; i <res.data.length; ++i){
                            this.origin.push(res.data[i].url);
                        }
                    }
                })
        },
        savePagePic(){
            this.sendArray= [];
            if(this.id==1 && this.jwtToken !="" && this.jwtToken !=null ){
                for (var item =0; item < this.pictures.length; ++item){
                    if(this.pictures[item].url != this.origin[item] ){
                        this.sendArray.push(this.pictures[item])
                    }
                }
                if(this.add.url!=""){
                    this.sendArray.push(this.add);
                }
                savePictures(this.sendArray).then(res =>{
                    if(res.code=="200"){
                        alert("保存成功");
                    }
                })
            }
        }
    }
}
</script>

<style scoped>
.picform{
    background: rgb(101, 255, 196);
    margin: 4%;
    padding: 4%;
}
.title{
    text-align: center;
    font-family: STXingkai ;
    margin-top: 3%;
    font-size: 50px;
}
</style>