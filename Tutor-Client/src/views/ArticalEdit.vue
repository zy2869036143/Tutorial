<template>
    <div class="messa" style="text-align: center; padding-top: 30px; font-family: STXingkai;">
        文章编辑页{{bid}}
    </div>
   <div class="m-container">
    <div class="header">
        <img src="../assets/bg.png">
    </div>
    <div class="m-content">
      <el-form ref="editForm" status-icon :model="editForm" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="editForm.title"></el-input>
        </el-form-item>
        <el-form-item label="摘要" prop="description">
          <el-input type="textarea" v-model="editForm.description"></el-input>
        </el-form-item>
        <el-form-item label="封面图" prop="banner">
          <el-input type="text" v-model="editForm.url"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="ctype">
          <el-radio-group v-model="editForm.ctype">
            <el-radio label="0" name="ctype">推文</el-radio>
            <el-radio label="1" name="ctype">笔记</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <MdEditor class="mdEditor" v-model="editForm.content"/>
        </el-form-item>
        <el-form-item>
            <div class="action">
                <el-button  type="primary" @click="submitForm()">立即创建</el-button>
                <el-button type="danger"   v-show="(this.bid!=undefined)" @click="deleteAr();" >删除文章</el-button>
                <el-button  type="success" v-show="(this.bid!=undefined)" @click="toView()">视图模式</el-button>
            </div>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
import 'github-markdown-css/github-markdown.css'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { postBlogById, blogEdit, deleteBlog} from "../services"
import { mapState } from 'vuex'
import { ElMessage } from 'element-plus'

export default {
    name: "ArticleEdit",
    components: {
      MdEditor
    },
    computed: {
      ...mapState([
        'account', 'id'
      ])  
    },
    setup() {
      const warn = (inf) => {
        ElMessage({
            showClose: true,
            message: inf,
            type: 'warning',
          })
        }

        const success = (inf) => {
          ElMessage({
            message: inf,
            type: 'success',
          })
        }
        return{
            success,
            warn,
        }
    },  
    data() {
      return {
        bid : "",
        a_content: "",
        editForm: {
          id: null,
          title: '',
          description: '',
          url:"",
          ctype: 0,
          content: ''
        },
        rules: {
          title: [
            {required: true, message: '请输入标题', trigger: 'blur'},
            {min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur'}
          ],
          ctype: [
             {required: true, message: '请选择文章类型', trigger: 'blur'},
          ],
          description: [
            {required: true, message: '请输入摘要', trigger: 'blur'}
          ]
        }
      }
    },
    created() {
        this.bid = this.$route.params.id;
        this.editForm.id = this.bid;
        this.getBlogInformation();
    },
    methods: {
        submitForm() {
            this.editForm.userId = this.id;
            this.editForm.banner = this.editForm.url;
            blogEdit(this.editForm).then(res =>{
              if(res.data == null){
                alert("你好调皮啊，想改别人的文章?")
              }else
                this.success(res.data);
                this.$router.push("/userhome/"+ this.id);
            })
        },
        getBlogInformation(){
            postBlogById(this.bid).then(res =>{
                this.editForm.title = res.data.title;
                this.editForm.description = res.data.description;
                this.editForm.content = res.data.content;
                this.editForm.url = res.data.banner;
                this.editForm.ctype = res.data.ctype+"";
            })
        },
        toView(){
          this.$router.push("/article/"+ this.bid)
        },
        deleteAr(){
            var decision = confirm("您确定要删除该文章吗？");
            if(decision === true){
              deleteBlog(this.bid, this.id).then(res =>{
                if(res.code==200){
                  this.success(res.data);
                  this.$router.push('/userhome/' + this.id)
                }else{
                  this.warn("你好调皮啊，想删别人的文章？");
                }
              })
            }
        }
    }
}
</script>

<style scoped>
.img{
    height:100px;
    width: 100% ;
    z-index: 1;
}
.header{
    height: 100px;
    text-align: center;
    /* background-image: url("../assets/bg.png"); */
}
.m-container{
    z-index: 10;
    background: transparent;
}
.mdEditor{
    height: 700px;
}
.action{
    text-align: center;
}
</style>