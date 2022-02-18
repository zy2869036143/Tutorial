<template>
<div class="box">
  <el-form
    ref="ruleForm"
    :model="ruleForm"
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
  >
   <el-form-item label="学号" prop="username" class="item">
      <el-input v-model="ruleForm.account" :disabled='account!==""'></el-input>
    </el-form-item>

    <el-form-item label="真实姓名" prop="name" class="item">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <!-- <el-form-item label="性别" prop="region">
      <el-select v-model="ruleForm.region" placeholder="下拉选择">
        <el-option label="Zone one" value="shanghai"></el-option>
        <el-option label="Zone two" value="beijing"></el-option>
      </el-select>
    </el-form-item> -->

    <el-form-item label="性别" prop="gender" class="item">
      <el-radio-group v-model="ruleForm.gender">
        <el-radio label="男" name="gender"></el-radio>
        <el-radio label="女" name="gender"></el-radio>
      </el-radio-group>
    </el-form-item>
    
    <el-form-item label="学校" prop="university" class="item">
      <el-input v-model="ruleForm.university"></el-input>
    </el-form-item>

    <el-form-item label="头像" prop="avatar" class="item">
      <el-input v-model="ruleForm.avatar"></el-input>
      <img :src="ruleForm.avatar" style="width:100px; height:100px" alt="">
        <el-avatar :src="ruleForm.avatar"></el-avatar>
    </el-form-item>

    <el-form-item label="专业" prop="major" class="item">
      <el-input  v-model="ruleForm.major"></el-input>
    </el-form-item>
   
    <el-form-item label="自我简介" prop="desck" class="item">
      <el-input v-model="ruleForm.desck" type="textarea" height="500px"></el-input>
    </el-form-item>
    
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')"
        >保存</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import {getUserInfor, updateUserInf} from '../services'
import { ElMessage } from 'element-plus'

export default {
    setup() {
        const success = (cid) => {
            ElMessage({
                message: cid,
                type: 'success',
            })
        }
        return{
            success,
        }
    },
  computed: {
      
  },
  created(){
    this.uid = JSON.parse(decodeURIComponent(this.$route.params.id));
    this.getInfor();
  },
//   mounted() {
//         this.$nextTick(this.getInfor());      
//   },

  data() {
    return {
      ruleForm: {
        account: "",
        name: '',
        avatar: '',
        gender: '',
        university: '山东大学',
        major: '',
        desck: '',
      },
      uid: 0,
      rules: {
        account: [
          {
            required: true,
          }
        ],
        name: [
          {
            required: true,
            message: '请输入您的真实姓名',
            trigger: 'blur',
          },
          {
            min: 2,
            max: 5,
            message: '姓名应该为2-5个汉字',
            trigger: 'blur',
          },
        ],
        gender : [
          {     required: true,
                message: "请选择一个",
                trigger: 'blur',
          } 
        ],
        university :[
            {
                required: true,
                message: "请输入您所在大学的全称",
                trigger: 'blur',
            }
        ],
        major: [
            {
                required: true,
                message: "请输入您所学专业",
                trigger: 'blur',
            }
        ]
      },
    }
  },
  methods: {
    myUpdate(){
        this.ruleForm.id = this.uid;
        updateUserInf(this.ruleForm).then(res =>{
            if(res.code==200){
                this.success("修改信息成功");
                this.$router.push("/userhome/"+ this.uid);
            }
        })
    },

    getInfor(){
      getUserInfor(this.uid).then(res =>{
        this.uid = res.data.id;
        this.ruleForm.account = res.data.account;
        this.ruleForm.name = res.data.name;
        this.ruleForm.gender = res.data.gender;
        this.ruleForm.university = res.data.university;
        this.ruleForm.major = res.data.major; 
        this.ruleForm.desck =  res.data.desck;
        this.ruleForm.avatar = res.data.avatar;
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.myUpdate();
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
  },
}
</script>

<style scoped>
.item{
    padding-top: 41px;
}
.box{
    font-size: 20px;
    margin-right: 3%;
    padding-right: 2%;
    margin-top: 1%;
    padding-bottom: 1%;
    margin-left: 3%;
    background: linear-gradient(135deg, #55efcb 0%, #1e5799 0%, #55efcb 0%, #5bcaff 100%);
    border-radius: 20px;
    margin-bottom: 1%;
}

</style>