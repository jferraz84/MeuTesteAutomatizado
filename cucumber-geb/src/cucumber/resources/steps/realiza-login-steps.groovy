import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By


Dado(/que navego até a página de busca do banco de questões/) {  ->
    to ModulesPage
    browser.driver.manage().window().maximize()
}

Dado(/seleciono a opção de Login/) {  ->
    //Clica no botão de Login
    waitFor(10){
        page.btnLogin.click()
    }
    Thread.sleep(1500)
}

Dado(/digito {string} no campo de Username/) { String userName ->
    //Insere o nome do Usuario
    waitFor(10){
        page.insereNameUser.value(userName)
    }
    Thread.sleep(1500)
}

Dado(/digito {string} no campo de Password/) { String passwordUser ->
    //Insere o Password do Usuario
    waitFor(10){
        page.inserPasswordUser.value(passwordUser)
    }
    Thread.sleep(1500)
}

Quando(/clico no botão SignIN e retorno a página inicial de busca do banco de questões/) {  ->
    //Clica no botão para se logar
    waitFor(10){
        page.btnSignIn.click()
    }
    Thread.sleep(1000)
}

Quando(/seleciono a opção de Login novamente e clico no botão Logout/) {  ->
    //Clica no botão de Login
    waitFor(10){
        page.btnUserDeslogar.click()
    }
    Thread.sleep(1000)

    //Clica no botão de LogOut para deslogar
    waitFor(10){
        page.btnLogOut.click()
    }
    Thread.sleep(1500)

}

Então(/retorno a página inicial/) {  ->
    //Atualiza a página

     browser.driver.navigate().refresh()  
     Thread.sleep(1000)
}