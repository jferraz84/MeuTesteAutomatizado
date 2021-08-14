import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By


Dado(/que navego para a página de buscar no banco de questões/) {  ->
    to ModulesPage
    browser.driver.manage().window().maximize()
}

Dado(/clique para expandir o modo de pesquisa/) {  ->
    //Expandi o modulo de pesquisa
    waitFor(10){
        page.expandirPesquisa.click()
    }
    Thread.sleep(1000)
}

Dado(/digito {string} no campo de buscar/) { String valorPesq ->
    //Digita o valor da pesquisa
    waitFor(10){
        page.campoPesquisa.value(valorPesq)
    }
    Thread.sleep(1000)
}

Então(/visualizo a listagem de questões deve estar com {int} itens e navega pelo controle de paginação/) { Integer valorBuca ->

    def lista = []
     
        lista = $(By.xpath("//*[@id='page-top']/div[2]/table/tbody//td[1]"))*.text()

        assert lista.size() == valorBuca

        println "Valor da Lista = " + lista.size()

     Thread.sleep(2000)

    browser.driver.executeScript("window.scrollTo(0, 300)")

    waitFor(10){
        page.navega1PelaPagina.click()
    }
    Thread.sleep(1500)

    waitFor(10){
        page.navega2PelaPagina.click()
    }
    Thread.sleep(2000)

    waitFor(10){
        page.navega3PelaPagina.click()
    }
    Thread.sleep(2000)
}