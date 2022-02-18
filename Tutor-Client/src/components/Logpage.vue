<template>
<body>
  
<section class="container">

  <div class="span-6">
    <div class="login">
      <h1>青鸟筑梦</h1>
      <div class="login-content">
        <form @submit.prevent='handleSubmit'>
          <label id="emailLabel">Please enter a valid email</label>
          <input id="email" v-model="account"  placeholder="账号" />
          <label id="passwordLabel">Please enter your password</label>
          <input type="password" v-model="password" id="password" placeholder="密码" /><br>
            <a href="">忘记密码</a>&#x2022;<a href="">忘记账号</a><br>
          <input type="submit" value="登录">
        </form>
      </div>
    </div>
  </div>
  <div class="span-6">
    <div class="message">
      <span class="first">Learning</span>
      <span class="second">is</span>
      <span class="third">lifelong</span>
    </div>
  </div>
</section>
</body>





</template>

<script>
import { ElMessage } from 'element-plus'

export default {
    name: "login",
    data(){
        return {
            "account" : "",
            "password": ""
        }
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
    methods:{
        handleSubmit(){
        const { account, password} = this;
        if(account=="") this.warn("请输入您的账号")
        else if(password=="") this.warn("请输入您的密码")
        else {
            this.$store.dispatch('login', {
                account : account,
                password : password,
            }
            )
        }
        }
    }
}
</script>

<style scoped>



@import url(https://fonts.googleapis.com/css?family=Rokkitt);
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700);
@import url(https://fonts.googleapis.com/css?family=Roboto+Slab:700,400);
@import url(https://fonts.googleapis.com/css?family=Lobster);


* { margin: 0; padding: 0; -moz-box-sizing: border-box; box-sizing: border-box; }

h1 { font-family: 'Rokkitt', serif; }

body {
  height: 100%;
  background: url('https://unsplash.s3.amazonaws.com/batch%206/park-place.jpg') no-repeat center center fixed;
  background-size: cover;
  margin: 0 auto;
  width: 66%;
  font-family: 'Open Sans', sans-serif;
} 


.container {
  width: 66%;
  min-width: 800px;
  position: absolute;
  top: 20%;
}
.span-6 {
  float: left;
  width: 49%;
  margin-right: 1%;
}

.login {
  background-color: #444444;
  text-align: center;
  box-shadow: 0 0 20px #000;
}
.login h1 {
  color: #A64141;
  font-size: 36px;
  padding: 30px;
  background-color: #d25555;
}
.login-content, .message {
  padding: 30px 30px 50px 30px;
}
.login-content a {
  text-decoration: none;
  font-size: 14px;
  color: #ccc;
}
label {
  display: block;
  color: #f4f4f4;
  font-size: 18px;
  margin-bottom: 3px;
  opacity: 0;
  
  transition: all .3s ease-in-out;
}
input {
  margin-bottom: 15px;
  padding: 10px 5px;
  width: 80%;
  background-color: #ccc;
  border: none;
  text-align: center;
  font-size: 16px;
  font-family: 'Open Sans', sans-serif;
  font-weight: bold;
  color: #333;
}
input:focus {
  background-color: #f4f4f4;
  border: none;
  outline: none;
}

input[type=submit] {
  color: #fff;
  background-color: #d25555;
  border: none;
  font-family: 'Rokkitt', serif;
  font-size: 24px;
  margin-top: 25px;
  width: 60%;
  
  transition: all .5s ease;
}
input[type=submit]:hover {
  background-color: #A64141;
  cursor: pointer;
  color: #f4f4f4;
}

.message {
  
}
.message span {
  display: block;
  color: rgb(255, 167, 4);
  position: relative; 
  bottom: 80px;
  text-align: center;
}
.line {
  display: inline-block;
  padding: 2px;
  background-color: rgb(255, 251, 21);
  -webkit-transform: rotate(-12deg);
  -moz-transform: rotate(-12deg);
  transform: rotate(-12deg);
  width: 5px;
}
.first, .second, .third {
  font-size:10em;
  -webkit-transform: rotate(-12deg);
  -moz-transform: rotate(-12deg);
  transform: rotate(-12deg);
  letter-spacing: -4px;
}
.first {
  font-family: 'Lobster', cursive;
  -webkit-text-shadow: 3px 3px 0 #999;
  -moz-text-shadow: 3px 3px 0 #999;
  text-shadow: 3px 3px 0 #999;
}
.second {
  font-size: 4em;
  font-family: 'Pacifico', cursive;
  text-align: center;
  border: 8px solid rgb(235, 252, 8);
  width: 95px;
  height: 95px;
  border-radius: 50%;
  line-height: 75px;
  margin: 0 auto;
  font-family: 'Roboto Slab', serif;
  position: relative;
  left: 50px;
}
.second:before {
  content: "";
  display: block;
  padding: 1px; 
  background-color: rgb(255, 209, 6);
  width: 170px;
  position: absolute;
  top: 50%;
  right: 110px;
}
.second:after {
  content: "";
  display: block;
  padding: 1px; 
  background-color: rgb(255, 211, 13);
  width: 170px;
  position: absolute;
  top: 50%;
  left: 110px;
}
.third {
  font-size: 8em;
  font-family: 'Lobster', cursive;
  -webkit-text-shadow: 3px 3px 0 #999;
  -moz-text-shadow: 3px 3px 0 #999;
  text-shadow: 3px 3px 0 #999;
  line-height: 150px;
}
.show {
  opacity: 1;
}





</style>