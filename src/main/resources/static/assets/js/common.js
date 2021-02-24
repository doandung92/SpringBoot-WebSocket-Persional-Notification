function successAlert(message){
    $.bootstrapGrowl(message, {
        type: 'alert alert-custom alert-light-primary show mb-5',
        align: 'center',
        width: 'auto',
        allow_dismiss: false
    });
}

function failAlert(message){
    $.bootstrapGrowl(message, {
        type: 'alert alert-custom alert-light-danger show mb-5',
        align: 'center',
        width: 'auto',
        allow_dismiss: false
    });
}


