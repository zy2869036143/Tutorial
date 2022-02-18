
<template>
  <el-upload
    ref="upload"
    action="http://localhost:8282/uploadFile"
    :limit="1"
    accept=".txt"
    :on-exceed="handleExceed"
    :on-success="upLoadSuccess">
    <template #trigger>
      <el-button type="primary">选择文件</el-button>
    </template>
    <el-button class="ml-3" type="success" @click="submitUpload()">上传文件</el-button>
    <template #tip>
      <div class="el-upload__tip" style="color: red">
        仅允许上传一个文件
      </div>
    </template>
  </el-upload>
</template>

<script>
import { onMounted, ref } from 'vue'
const upload = ref()
export default {
    data(){
        return {
            file : ""
        }
    },
    setup(){
        const refDiv = ref() 
        onMounted(()=>{
            refDiv;
            console.log("refDiv.value");
            console.log(upload.value)
        });
    },
    methods:{
        submitUpload(){
            this.file = $("#file");
            console.log("上传文件");
            console.log(upload.value);
            upload.value.submit();
        },
        upLoadSuccess(){
            alert("上传成功")
        }
    }
}
</script>
<style>
</style>