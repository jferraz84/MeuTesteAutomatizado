package pages

import org.openqa.selenium.By
import pages.base.BasePage

class ModulesPage extends BasePage {
	static at = { title == "Open Trivia DB: Free to use, user-contributed trivia question database." }

  static content ={

    // Mapeamento para Busca por questão inexistente
    expandirPesquisa  {$(By.xpath("//*[@id='navbar']/ul/li[1]/a"))}
    campoPesquisa     {$(By.xpath("//*[@id='query']"))}
    btnBuscar         {$(By.xpath("//*[@id='page-top']/div[1]/form/div/button"))} 

    // Mapeamento para Busca por questão por categoria
    navega1PelaPagina {$(By.xpath("//*[@id='page-top']/div[2]/center/ul/li[2]/a"))}
    navega2PelaPagina {$(By.xpath("//*[@id='page-top']/div[2]/center/ul/li[3]/a"))}
    navega3PelaPagina {$(By.xpath("//*[@id='page-top']/div[2]/center/ul/li[4]/a"))}

    // Mapeamento para Busca por User cadastrado
    btnLogin          {$(By.xpath("//*[@id='navbar']/ul/li[5]/a"))}
    insereNameUser    {$(By.xpath("//*[@id='username']"))}
    inserPasswordUser {$(By.xpath("//*[@id='password']"))}
    btnSignIn         {$(By.xpath("//*[@id='page-top']/div[2]/form/div[2]/button"))}
    btnUserDeslogar   {$(By.xpath("//*[@id='navbar']/ul/li[6]/a"))}
    btnLogOut         {$(By.xpath("//*[@id='navbar']/ul/li[6]/ul/li[4]/a"))}
    
  }
}
