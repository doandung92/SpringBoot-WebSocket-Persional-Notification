const url = 'http://localhost:8080';
let stompClient, $name, $connectBtn , $sendBtn, $info, $messageBox, $message, $destination;

$( document ).ready(function (){
    $name = $("#name");
    $connectBtn = $("#connect-btn");
    $sendBtn = $("#send-btn");
    $info = $("#info");
    $messageBox = $("#messageBox");
    $message = $("#message");
    $destination = $("#destination");

    $connectBtn.on('click', function (){
        connectServer($name.val());
        successAlert("Hello " + $name.val());
    });

    $sendBtn.on('click', function (){
        let message = {
            from: $name.val(),
            to: $destination.val(),
            message: $message.val()
        }

        stompClient.send("/app/notification-server/" + $destination.val(), {}, JSON.stringify(message));
        $message.val("");
    });
});

function connectServer(name) {
    let socket = new SockJS(url + '/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({},onConnect);

}

let onConnect = function (frame) {
    stompClient.subscribe("/topic/notification-client/" + $name.val(), onReceive);
    $info.hide()
    $messageBox.show()
};

let onReceive = function (response) {
    let data = JSON.parse(response.body);
    successAlert(data.message)
}

