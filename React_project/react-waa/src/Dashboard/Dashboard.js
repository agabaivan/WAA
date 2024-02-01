import React, { useEffect, useState } from 'react'
import Posts from '../container/Posts'
import axios from 'axios';
import PostDetails from '../components/PostDetails';
import AddPost from '../components/AddPost';


const Dashboard = () => {
  const [selectedPostId, setSelectedPostId] = useState(null);
  const [posts, setPosts] = useState([]);

  const handlePostClick = (postId) => {
    setSelectedPostId(postId);
  };

  const handlePostAdded = (newPost) => {
    setPosts([...posts, newPost]);
  };


  const handlePostDelete = (postId) => {
    setPosts(posts.filter(post => post.id !== postId));
  };



  useEffect(() => {

    axios.get(`http://localhost:8080/api/v1/posts`)
      .then(response => setPosts(response.data))
      .catch(error => console.error('Error getting the posts', error));
  }, []);


  return (
    <div>
      <h1>Dashboard</h1>
      <AddPost onPostAdded={handlePostAdded} />
      <Posts onPostClick={handlePostClick} />
      {selectedPostId && (
        <PostDetails postId={selectedPostId} onDelete={handlePostDelete}  />
      )}
      



    </div>
  )
}
export default Dashboard;
