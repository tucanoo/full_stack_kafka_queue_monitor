import React, { useState, useEffect, startTransition } from 'react';

const KafkaMonitor = () => {
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchMessages = async () => {
      try {
        let response = await fetch('http://localhost:8080/api/messages/all');
        if (response.ok) {
          let data = await response.json();
          startTransition(() => {
            setMessages(data);
            setLoading(false);
          });
        } else {
          console.error('Failed to fetch messages');
        }
      } catch (error) {
        console.error('Error fetching messages:', error);
      }
    };

    fetchMessages();

    const interval = setInterval(fetchMessages, 10000);  // Fetch every 10 seconds
    return () => clearInterval(interval);
  }, []);

  return (
    <div>
      {loading ?
        <div className="d-flex justify-content-center my-3">
          <div className="spinner-border" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
        </div>
        :
        <ul className="list-group">
          {messages.map((message, idx) => <li key={idx} className="list-group-item">{message}</li>)}
        </ul>
      }
    </div>
  );
};

export default KafkaMonitor;
