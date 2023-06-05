<template>
  <el-dialog v-if="selectedMovie" v-model="isMovieDetailsModalVisible" width="50%">
    <div v-if="movie">
      <h2>{{ movie.title }}</h2>
      <div class="poster">
        <img :src="movie.posterUrl" :alt="movie.title"/>
      </div>
      <div class="details">
        <p><strong>评分：</strong> {{ movie.rating }} / 10</p>
        <p><strong>导演：</strong> {{ movie.director }}</p>
        <p><strong>主演：</strong> {{ movie.cast.join(', ') }}</p>
        <p><strong>简介：</strong> {{ movie.description }}</p>
      </div>
    </div>
    <span slot="footer" class="dialog-footer">
<el-button @click="handleClose">关闭</el-button>
</span>
  </el-dialog>
</template>

<script>
export default {
  props: {
    movie: {
      type: Object,
      default: null,
    },
    visible: {
      type: Boolean,
      default: false,
    },
  },
  created() {
    // 当组件创建时打印 props 的值
    console.log('Movie prop:', this.movie);
    console.log('Visible prop:', this.visible);
  },
  methods: {
    handleClose() {
      this.$emit("close");
    },
  },
};
</script>
<style scoped>
.poster {
  float: left;
  margin-right: 20px;
}

.details {
  overflow: hidden;
}
</style>