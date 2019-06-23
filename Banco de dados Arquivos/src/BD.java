//ID INTEGER,Nome VARCHAR(30),Genero Varchar(10),Idade Integer,Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Advertencias INTEGER)
//Morador(String nome,String genero,Date data_nascimento,int ano_ingresso,Date previsao_saida)
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
 public class BD {
    /**
     *
     * @param Tabela
     */
    //checa se Tabela Predio existe
    //necessario para checar se banco de dados foi inicializado
    public static int checa_Tabela(){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    int i = 1;
    try{
    INSERT_RECORD = ("UPDATE Predio SET N_Predio = ? WHERE N_Predio = ?");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, i); //seta primeira ?
    pstmt.setInt(2,i);  //seta segunda ?
    
    
    pstmt.executeUpdate();
    }catch(java.sql.SQLSyntaxErrorException a){

     return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0; //checagem completa
    }
    //cria tabela para Morador
    //ID INTEGER,Nome VARCHAR(30),Idade INTEGER,Genero Varchar(10),Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Advertencias INTEGER
    public static void criar_Tabela_Morador(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(ID INTEGER,Nome VARCHAR(30),Idade INTEGER,Genero Varchar(10),Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Advertencias INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //cria tabela para Predio
    //N_Predio INTEGER,N_Ocupantes INTEGER  
     public static void criar_Tabela_Predio(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(ID INTEGER,N_Ocupantes INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //cria tabela para Bloco
    //campos N_Bloco INTEGER,N_Ocupantes INTEGER
     public static void criar_Tabela_Bloco(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(ID INTEGER,N_Ocupantes INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
     //cria tabela para Apartamento
     //N_Apartamento INTEGER,Genero VARCHAR(10),N_Ocupantes INTEGER),Nome_Arquivo VARCHAR(20)
     public static void criar_Tabela_Apartamento(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + " (ID INTEGER, Genero VARCHAR(10), N_Ocupantes INTEGER,Nome_Arquivo VARCHAR(20))");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
     //cria tabela para cama
     //campos ID INTEGER Status INTEGER,Data DATE
     public static void criar_Tabela_Cama(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(ID INTEGER,Status INTEGER,Data DATE)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //exclui Tabela
    public static void exclui_Tabela(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("DROP TABLE " + Tabela);
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela excluida com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //exclui do banco de dados dependendo do ID
    //retorna 0 se sucesso e 1 - se ocorreu erro
    public static int exclui_Morador(String Nome, String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "DELETE FROM "+ Tabela + " WHERE Nome = ? ";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, Nome);
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1; //erro
    }
    stm.execute("SHUTDOWN");
    retorno = 2;//sucesso
    return retorno;
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return -1; //erro try catch
    }
    //muda se campo é previsao de saida,data_saida,data_nascimento retorna um valor inteiro
    //1 - para caso ocorra erro e 0 se não ocorreu erro todos os updates são assimm
    public static int update_Tabela(Date Valor_troca,String Tabela,String Campo,String nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where Nome = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setDate(1, Valor_troca); //seta primeira ?
    pstmt.setString(2,nome);  //seta segunda ?
    
   int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1; //erro
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0;//update completo
    }
    //se campo é Nome ou Genero
    public static int update_Tabela(String Valor_troca,String Tabela,String Campo,String nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where Nome = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, Valor_troca); //seta primeira ?
    pstmt.setString(2,nome);  //seta segunda ?
    
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1; // erro
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0; //update completo
    }
    //se campo é idade,ano_de_ingresso,predio,bloco,apartamento,advertencias
    public static int update_Tabela(int Valor_troca,String Tabela,String Campo,String nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where Nome = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, Valor_troca); //seta primeira ?
    pstmt.setString(2,nome);  //seta segunda ?
    
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1; //erro
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0; //update completo
    }
    //insere no banco de dados o objeto morador na tabela morador
    //retorn 1 - se houve erro na inserção e 0 se não houve erro
    public static int insere(Morador m,int ID,String Tabela){
    String nome,genero;
    Date data1,data2;
    int ano;
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    nome = m.getNome();
    genero = m.getGenero();
    int idade = m.getidade();
    data1 = (Date) m.getData_nascimento();
    ano = m.getAno_ingresso();
    data2 = (Date) m.getPrevisao_saida(); 
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into " + Tabela + " (ID,NOME,IDADE,GENERO,Data_de_Nascimento,Ano_de_Ingresso,PREVISAO_SAIDA) VALUES(?,?,?,?,?,?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, ID); // seta primeira ?
    pstmt.setString(2, nome);
    pstmt.setInt(3, idade);
    pstmt.setString(4, genero);
    pstmt.setDate(5, data1);
    pstmt.setInt(6, ano);
    pstmt.setDate(7, data2);
    
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    return 0;
    }
    //insere na tabela predio os valores
    public static int insere_Predio(int num_Predio,int n_pessoas,String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into " + Tabela + " (ID,N_Ocupantes) VALUES(?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, num_Predio); // seta primeira ?
    pstmt.setInt(2, n_pessoas);
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    return 0;
    }
    //insere na tabela bloco os valores
    public static int insere_Bloco(int num_Bloco,int n_pessoas,String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into " + Tabela + " (ID,N_Ocupantes) VALUES(?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, num_Bloco); // seta primeiro simbolo "?"
    pstmt.setInt(2, n_pessoas);
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    return 0;
    }
    //insere na tabela de Apartamento
    public static int insere_Apartamento(int num_Apartamento,String Genero,int n_pessoas,String Nome_Arquivo,String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into " + Tabela + " (ID,Genero,N_Ocupantes,Nome_Arquivo) VALUES(?,?,?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, num_Apartamento); // seta primeiro simbolo "?"
    pstmt.setString(2, Genero);
    pstmt.setInt(3, n_pessoas);
    pstmt.setString(4, Nome_Arquivo);
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    return 0;
    }
    //Status INTEGER,Data DATE
    public static int insere_Cama(int ID_Cama,int status,Date Data,String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into " + Tabela + " (ID,Status,Data) VALUES(?,?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, ID_Cama); // seta primeiro simbolo "?"
    pstmt.setInt(2, status);
    pstmt.setDate(3, Data);
    int retorno = pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    //retorno checa se atualizou ou nao
    if(retorno==0)
    {return 1;
    }
    //coloca a statement insery_record em executeUpdate para atualizar o valor
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    return 0;
    }
    //Recebe o valor de um campo e indica o campo assim como a tabela consultada
    //retorna o nome de todos os moradores com este valor
    //caso o campo for previsao de saida,data_saida,data_nascimento 
    public static void seleciona_Tabela(Date Valor_compara,String Tabela,String Campo){
    try{
    String name,lista = "";
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);
      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    ArrayList<String> nomes = new ArrayList<String>();
    ResultSet rs;
    rs = stm.executeQuery(query);
    int i = 0;
    while(rs.next()){
    Date temp = rs.getDate(Campo);
        if(temp.equals(Valor_compara))
        {name = rs.getString("nome");
         nomes.add(i, name);
         i++;
        }
    }
    Iterator< String > iterator = nomes.iterator(); 
    do
    {name = iterator.next();
     lista = (lista + name + "\n");
    }while( iterator.hasNext() );
     JOptionPane.showMessageDialog(null,lista);
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //caso campo é Nome ou Genero
    public static void seleciona_Tabela(String Valor_compara,String Tabela,String Campo){
    try{
    String name,lista = "";
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);
      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    ArrayList<String> nomes = new ArrayList<String>();
    ResultSet rs;
    rs = stm.executeQuery(query);
    int i = 0;
    while(rs.next()){
    String temp = rs.getString(Campo);
        if(temp.equals(Valor_compara))
        {name = rs.getString("nome");
         nomes.add(i, name);
         i++;
        }
    }
    if(i!=0)
    {Iterator< String > iterator = nomes.iterator(); 
     do
     {name = iterator.next();
      lista = (lista + name + "\n");
     }while( iterator.hasNext() );
     JOptionPane.showMessageDialog(null,lista);   
    }
    else
    {JOptionPane.showMessageDialog(null,"Valor procurado não encontrado");   
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
     //caso campo é idade,ano_de_ingresso,predio,bloco,apartamento,advertencias
   public static void seleciona_Tabela(int Valor_compara,String Tabela,String Campo){
    try{
    String name,lista = "";
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);
      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    ArrayList<String> nomes = new ArrayList<String>();
    ResultSet rs;
    rs = stm.executeQuery(query);
    int i = 0;
    while(rs.next()){
    int temp = rs.getInt(Campo);
        if(temp == Valor_compara)
        {name = rs.getString("nome");
         nomes.add(i, name);
         i++;
        }
    }
    Iterator< String > iterator = nomes.iterator(); 
    do
    {name = iterator.next();
     lista = (lista + name + "\n");
    }while( iterator.hasNext() );
     JOptionPane.showMessageDialog(null,lista);
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //retorna 0, se não existir o ID na tabela ou retorna o proprio o numero de ocupantes do apartamento
   // -1 é retornado em caso de erro;
   //usado para não permitir duplicação de ID
     public static int seleciona_ID(String Tabela,int ID){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT ID FROM " + Tabela);

      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    ResultSet rs;
    rs = stm.executeQuery(query);
    int cont = 0;
    while(rs.next()){
    int i = rs.getInt("ID");
        if(i == ID)
        {cont++;
    }
    }
    stm.execute("SHUTDOWN");
    System.out.println(cont + " \n");
    return cont;
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return -1;
    }
    // usado para pegar o numero de pessoas da tabela
    public static int get_Int(String Campo,String Tabela,int ID){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);

      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    ResultSet rs;
    rs = stm.executeQuery(query);
    while(rs.next()){
    int i = rs.getInt("ID");
        if(i == ID)
        {i = rs.getInt(Campo);
         return i; //retorna numero de moradores do campo informado
        }
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0;
    }
    // usado para pegar uma string da tabela
    public static String get_String(String Campo,String Tabela,int ID){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);// create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    ResultSet rs;
    rs = stm.executeQuery(query);
    while(rs.next()){
    int i = rs.getInt("ID");
        if(i == ID)
        {String a = rs.getString(Campo);
         return a; //retorna a string de campo informado
        }
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return null;
    }
     // usado para pegar um Date da tabela
    public static Date get_Date(String Campo,String Tabela,int ID){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM " + Tabela);// create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    ResultSet rs;
    rs = stm.executeQuery(query);
    while(rs.next()){
    int i = rs.getInt("ID");
        if(i == ID)
        {Date a = rs.getDate(Campo);
         return a; //retorna a string de campo informado
        }
    }
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return null;
    }
    //Procura um morador especifico e retorna todos os seus dados
    public static int seleciona_Morador(String Nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
     String query = ("SELECT * FROM Morador");
      // create the java statement
      Statement stm = con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    int cont =0;
    ResultSet rs;
    rs = stm.executeQuery(query);
    while(rs.next()){
    String nome = rs.getString("nome");
    if(Nome.equals(nome))
    {cont++;
     String genero = rs.getString("genero");
     int i = rs.getInt("ID");
     int idade = rs.getInt("idade");
     Date data1 = rs.getDate("Data_de_Nascimento");
     int  ano = rs.getInt("Ano_de_Ingresso");
     Date data2 = rs.getDate("PREVISAO_SAIDA");
     Date data3 = rs.getDate("Data_Saida");
     int predio = rs.getInt("Predio");
     int bloco = rs.getInt("Bloco");
     int apartamento = rs.getInt("Apartamento");
     int advertencia = rs.getInt("Advertencias");
     JOptionPane.showMessageDialog(null," ID: " + i + "\n Nome: " + nome + "\n Idade: " + idade + "\n Data de Nascimento: " + data1 + "\n Ano de Ingresso: " + ano + "\n Previsão de saida: " + data2 + " \n Data de Saida: " + data3 + "\n Predio: " + predio + "\n bloco: " + bloco + "\n Apartamento: " + apartamento + "\n Adverterncias: " + advertencia);
    }
   }
    stm.execute("SHUTDOWN");
    return cont;
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    return 0;
    }
    
    public static void main(String[] args) throws ParseException{
    String nome,genero;
    java.sql.Date data_nascimento,previsao_saida;
    int ano;
     ano = 2000; 
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     data_nascimento = new java.sql.Date(format.parse("20/06/2010").getTime());
     previsao_saida = new java.sql.Date(format.parse("30/12/1999").getTime());
     BD.criar_Tabela_Apartamento("Apartamento");
     
     }     
}