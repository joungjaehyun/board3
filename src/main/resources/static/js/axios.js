
// axios의 get method promise화
const getPosts = async () => {
    const res = await axios.get(path)
    return res.data
}
// id 값을 받아 axios의 get method promise화
const getPostOne = async (id) => {
    const res = await axios.get(`${path}/${id}`)
    return res.data
}
// id 값을 받아 axios의 delete method promise화
const deletePostOne = async (id) => {
    const res = await axios.delete(`${path}/${id}`)
    return res.data
}

// object를 받아 axios의 post method를 promise화
const addDataPost = async (obj) => {

    console.log(obj)
    const res = await axios.post(path, obj)
    return res.data
}
// object를 받아 axios의 put method를 promise화
const modifyPut = async (obj) => {

    console.log(obj)
    const res = await axios.put(`${path}/${obj.id}`, obj)
    return res.data
}
