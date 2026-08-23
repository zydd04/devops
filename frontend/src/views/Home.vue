<template>
  <div>
    <h1>Home</h1>
    <p>Backend says: {{ backendMessage }}</p>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'

const backendMessage = ref('loading...')

onMounted(async () => {
  try {
    const res = await fetch('/api/ping')
    const data = await res.json()
    backendMessage.value = data.message
  } catch (err) {
    backendMessage.value = 'failed to connect'
    console.error(err)
  }
})
</script>