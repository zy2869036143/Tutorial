<template>
    <el-form 
     ref="form"
     :model="form"
     :rules="rules"
     label-width="95px"
     class="edit">
        <el-form-item  prop="oldPassword" label="旧密码">
            <el-input type="password" v-model="form.oldPassword"></el-input>
        </el-form-item>
        <el-form-item  prop="newPassword" label="新密码" >
            <el-input type="password"  v-model="form.newPassword"></el-input>
        </el-form-item>
        <el-form-item  prop="newPasswordAgain" label="确认新密码" >
            <el-input type="password" v-model="form.newPasswordAgain"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="success" @click.prevent="update();">提交</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import { mapState } from 'vuex'
import { ElMessage } from 'element-plus'

import { editPassword} from "../services"
export default {
    setup() {
        const success = (cid) => {
            ElMessage({
                message: cid,
                type: 'success',
            })
        }
       const warn = (inf) => {
        ElMessage({
            showClose: true,
            message: inf,
            type: 'warning',
          })
        }
        return{
            success,
            warn
        }
    },
    data(){
        return{
            form:{
                oldPassword: "",
                newPassword: "",
                newPasswordAgain:""
            },
            rules:{
                oldPassword:[
                    {
                        required: true,
                        message: "请输入您原有密码",
                        trigger: "blur"
                    }
                ],
                newPassword:[
                    {
                        required: true,
                        message: '请输入您的新密码',
                        trigger: 'blur',
                    },
                    {
                        min: 6,
                        max: 25,
                        message: '新密码应该为6-25个字符',
                        trigger: 'blur'
                    }
                ],
                newPasswordAgain:[
                     {
                        required: true,
                        message: '请输入您的新密码',
                        trigger: 'blur',
                    }
                ]
            }
        }
    },
    computed: {
      ...mapState([
        'account', 'id'
      ])
    },
    methods:{
        update(){
            if(this.form.newPassword != this.form.newPasswordAgain){
                this.warn("两次密码不一致");
                return false;
            }
            if(this.id != null && this.id != undefined){
                editPassword(this.id, this.form.oldPassword, this.form.newPassword).then(res =>{
                    if(res.code==200){
                        this.success("修改密码成功");
                        this.$router.push("/userhome/"+ this.id);
                    }else{
                        this.warn("原密码错误");
                    }
                })
            }
        }
    }
}
</script>

<style scoped>
.edit{
    background: linear-gradient(135deg, #55efcb 0%, #1e5799 0%, #55efcb 0%, #5bcaff 100%);
    margin: 3%;
    padding: 5%;
}

</style>