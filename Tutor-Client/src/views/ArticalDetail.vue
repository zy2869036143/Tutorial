<template>
  <div class="img-container">
    <img :src=url alt="图片无法显示" style="width:100%">
  </div>
  <div class="brief">
      <h2>{{ title }}</h2>
      <h3>{{description}}</h3>
      <h4>创建时间：{{created}}</h4>
      <el-button type="success" @click="toEdit()" v-show="loggedIn & userId===id" >返回编辑</el-button>
  </div>
<div class="a"></div>
  <div class="mblog">
    <el-divider>
    </el-divider>
    <div class="markdown-body" v-html="content"></div>
  </div>
</template>

<script>
import { getBlogById} from "../services"
import { mapState } from 'vuex'

import 'github-markdown-css/github-markdown.css' // 然后添加样式markdown-body
export default {
  name: "ArticalDetail",
    data(){
        return {
          bid: null,
          userId: null,
          title: '',
          description: '',
          url:"https://images.unsplash.com/photo-1517021897933-0e0319cfbc28?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ",
          content: '',
          markDown: "",
          created: ""
        }
    },
    computed: {
      ...mapState([
        'account', 'loggedIn', 'id'
      ])  
    }, 
    created(){
        this.bid = this.$route.params.id;
        var MardownIt = require("markdown-it");
        var md = new MardownIt();
        this.markDown = md;
        this.getBlog();
    },
    methods:{
        getBlog(){
          getBlogById(this.bid).then(res =>{
            this.title = res.data.title;
            this.description = res.data.description;
            this.url = res.data.banner;
            this.userId = res.data.userId;
            this.created = res.data.created;
            this.content = this.markDown.render(res.data.content);
          })
        },
        toEdit(){
          this.$router.push("/article/edit/"+this.bid);
        }
    }
}
</script>

<style scoped>
*{
  font-family: "楷体","楷体_GB2312"
}
.img-container{
  width: 100%;
  height: 200px;
  z-index: 1;
  position: relative;
}
img{
  height: 400px;
}
.brief{
  width: 100%;
  text-align: center;
  position: absolute;
  color: white;
  z-index: 10;
}
.markdown-body{
  margin-top: 230px;
  margin-left: 5%;
  margin-right: 5%;
  padding-left: 2%;
  padding-top: 2%;
  padding-bottom: 2%;
  height: auto;
  border-radius: 1rem;
  box-shadow: 0 10px 50px 10px rgb(196, 196, 196);

}
.markdown-body:hover{
    box-shadow: 0 10px 50px 10px rgb(170, 170, 170);

}

</style>