import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Scanner;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.text.StyledEditorKit.FontFamilyAction;

public class StickerGenerator {
    /**
     * @throws IOException
     */
    public void create() throws IOException{
        //ler a imagem

        Scanner ler = new Scanner(System.in);
        System.out.println("Informe a url");
        String url;
        url = ler.nextLine();


        // ImageIO trabalha com imagens, e read ler uma imagem
        // BufferedImage imagemOriginal = ImageIO.read(new File("inputs/schoolOfRock.jpg")); 
        BufferedImage imagemOriginal = ImageIO.read(new URL(url));

        //Criar nova imagem em memoria com transp e tamanho novo
            //Isso será feito para redimensionar a nova imagem, baseada no tamanho da imagem original
        int Largura = imagemOriginal.getWidth();
        int Altura = imagemOriginal.getHeight();
        int novaAltura = Altura + 250;

        BufferedImage novaImagem = new BufferedImage(Largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original p/ a imagem criada
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte inserida
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 104);
        graphics.setFont(fonte);


        //Escrever uma frase na nova imagem

        System.out.println("Texto desejado:");
        String texto = ler.nextLine();
        ler.close();

        graphics.drawString(texto, (int) (Largura - (Largura * 0.75) ), (int) (novaAltura - (novaAltura * (0.15) )));


        //Criar um arq com a nova imagem
        ImageIO.write(novaImagem, "png", new File("imagem.png"));
    }

    public static void main(String[] args) throws IOException {
        var figurinha = new StickerGenerator();
        figurinha.create();
    }
}
