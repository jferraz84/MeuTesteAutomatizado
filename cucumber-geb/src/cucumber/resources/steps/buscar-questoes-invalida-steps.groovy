import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By


Dado(/que navego para a página de busca do banco de questões/) {  ->
    to ModulesPage
    browser.driver.manage().window().maximize()
}

Dado(/clique para expandir o mode de pesquisa/) {  ->
    //Expandi o modulo de pesquisa
    waitFor(10){
        page.expandirPesquisa.click()
    }
    Thread.sleep(1000)
}

Dado(/digito {string} no campo de busca/) { String valorPesq ->
    //Digita o valor da pesquisa
    waitFor(10){
        page.campoPesquisa.value(valorPesq)
    }
    Thread.sleep(1000)
}

Quando(/clico no botão de buscar/) {  ->
    //Clica para fazer a pesquisa
    waitFor(10){
        page.btnBuscar.click()
    }
    Thread.sleep(1000)
   
}

Então(/visualizo uma mensagem de erro com o texto {string}/) { String string ->
    to ModulesPage
    
    def msg_busca = $(By.xpath("//*[contains(text(), 'No questions found.')]")).text()

    if (msg_busca != null) {
        println $(By.xpath("//*[contains(text(),'No questions found.')]"),0).text()
        browser.driver.navigate().refresh()  
    }
    Thread.sleep(2000)

    waitFor(10){
         page.expandirPesquisa.click()
    }
    Thread.sleep(1000)
}
