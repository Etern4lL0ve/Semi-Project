<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chat Application</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        #chat-container {
            position: fixed;
            display: none;
            flex-direction: column;
            align-items: flex-end;
        }

        #chat-messages {
            font-size: 12px;
            overflow-y: auto;
            max-height: 300px;
            width: 220px;
            z-index: 1;
            position: fixed;
            top: 20px;
        }

        #chat-input {
            position: fixed;
            bottom: 380px;
            left: 10px;
            width: 200px;
            z-index: 2;
            height: 30px;
            display: none;
        }

        #chat-input .input-group {
            width: 100%;
        }

        #messageInput {
            width: calc(100% - 86px);
        }

        #sendMessageBtn {
            width: 86px;
            margin-top: 3px;
        }

        #toggleChatBtn {
            position: fixed;
            bottom: 300px;
            left: 10px;
            z-index: 3;
        }
    </style>
</head>
<body>
    <div id="chat-container">
        <div id="chat-messages"></div>
        <div id="chat-input">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="메세지를 입력하세요" id="messageInput">
                <button class="btn btn-warning" type="button" id="sendMessageBtn">전송</button>
            </div>
        </div>
    </div>
    <button class="btn btn-warning" type="button" id="toggleChatBtn">채팅시작</button>

    <script>
        $(document).ready(function () {
            var autoScroll = true; // 스크롤 활성화
            var userName; // 사용자 닉네임 저장 변수
            var chatInterval; // 채팅 조회 중지용 변수

				    // 숨기기
				    $("#chat-container, #sendMessageBtn, #chat-input").hide();
				
				    //  토글 버튼 클릭 이벤트
					$("#toggleChatBtn").click(function () {
				    if ($("#toggleChatBtn").text() === "채팅시작") {
				        // 시작 버튼을 눌렀을 때
				        if (!userName) {
				            
				            userName = prompt("닉네임을 입력하세요");
				        }
				
				        // 이름입력후 채팅시작
				        $("#chat-container").show();
				        $("#toggleChatBtn").text("채팅종료");
				        $("#sendMessageBtn, #chat-input").show();
				

				    } else {
				        // 최소화 버튼을 눌렀을 때
				        $("#sendMessageBtn, #chat-input").hide();
				        $("#toggleChatBtn").text("채팅시작").show();
					
				        alert("채팅을 다시 하시려면 페이지를 새로고침 하세요");
				        // 채팅창 비우기
				        stopChatPolling();
				        clearChatMessages();
				    }
				});
            

            // 메세지 조회 함수
            function getChatMessages() {
                $.ajax({
                    type: "POST",
                    url: "selectChat.ch",
                    dataType: "json",
                    success: function (response) {
                        var messagesDiv = $("#chat-messages");

                        // 역순으로 출력
                        for (var i = response.length - 1; i >= 0; i--) {
                            var message = response[i];
                            messagesDiv.append("<p><strong>" + message.chatName + ":</strong> " + message.chatContent + " - " + message.chatDate + "</p>");
                        }

                        if (autoScroll) {
                            // 자동 스크롤 설정
                            messagesDiv.scrollTop(messagesDiv.prop("scrollHeight"));
                            autoScroll = false;
                        }
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            }


            //조회 중지 함수
            function stopChatPolling() {
                clearInterval(chatInterval);
            }

            // 채팅창 비우기
            function clearChatMessages() {
                $("#chat-messages").empty();
            }

            // 전송 버튼 클릭 이벤트
            $("#sendMessageBtn").click(function () {
                var messageInput = $("#messageInput");
                var messageContent = messageInput.val().trim();

                if (messageContent !== "") {
                    $.ajax({
                        type: "POST",
                        url: "saveChat.ch",
                        data: { chatName: userName, chatContent: messageContent },
                        success: function (response) {
                            // 전송 후 조회
                            getChatMessages();
                            autoScroll = true; // 메세지 추가되면 스크롤 아래로
                        },
                        error: function (error) {
                            console.log(error);
                        }
                    });

                    // 인풋박스 초기화
                    messageInput.val("");
                }
            });

            // 자동스크롤 비활성화
            $("#chat-messages").on("scroll", function () {
                autoScroll = false;
            });
        });
    </script>
</body>
</html>