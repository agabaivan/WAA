import React, { useState } from 'react'
import '../Post/Post.css'

import Details from '../Details';
import DeletePost from '../DeletePost';



const Post = ({ id, title, author, onClick }) => {

  const [showDetails, setShowDetails] = useState(false);

  const toggleDetails = () => {
    setShowDetails(!showDetails);
    if (onClick) {
      onClick({ id, title, author });
    }
  };
  return (
    <div className="posts-container"  >
      <div class="post" onClick={toggleDetails}>
      <p>
        <strong>ID:</strong> {id}
      </p>
      <p>
        <strong>Title:</strong> {title}
      </p>
      <p>
        <strong>Author:</strong> {author}
      </p>
      <DeletePost postId={id} onDelete={onDelete}  />
      </div>

      {/* {showDetails && <Details post={{title, author }} onClose={() => setShowDetails(false)} />} */}
     
    </div>
  );
};

export default Post;

