// import Vue from 'vue'
import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'   // 导入element-plus
import 'element-plus/dist/index.css'     // 导入element-plus的ui的css文件 
import 'jquery'
import { store } from '@/store/createStore'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
createApp(App).use(ElementPlus).use(store).use(router).use(MdEditor).mount('#app')