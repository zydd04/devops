<script setup lang="ts">
</script>

<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/dashboard">Dashboard</router-link>
    <router-link to="/signup">Sign Up</router-link>
  </nav>
  <router-view />
</template>