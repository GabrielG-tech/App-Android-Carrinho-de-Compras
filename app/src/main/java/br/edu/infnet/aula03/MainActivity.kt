package br.edu.infnet.aula03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import br.edu.infnet.aula03.models.Carrinho
import br.edu.infnet.aula03.models.ItemCarrinho

class MainActivity : AppCompatActivity() {

    val TAG = "life"

    // Cria variaveis de view
    private lateinit var tvMouse: TextView
    private lateinit var tvQuantidadeMouse: TextView
    private lateinit var btnMaisMouse: Button
    private lateinit var btnMenosMouse: Button


    private lateinit var tvTeclado: TextView
    private lateinit var tvQuantidadeTeclado: TextView
    private lateinit var btnMaisTeclado: Button
    private lateinit var btnMenosTeclado: Button

    private lateinit var fechar: Button
    private lateinit var tvFechado: TextView



    // Cria o carrinho.
    var mouse = ItemCarrinho(1, 9.99, "mouse")
    var teclado = ItemCarrinho(1, 39.50, "teclado")
    var carrinho = Carrinho()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate()")

        setup()

    }

    fun setup(){
        setupViews()
        setupClickListeners()
    }


    // configura os cliques de botões
    private fun setupClickListeners() {
        btnMaisMouse.setOnClickListener {
            carrinho.adicionarItem( ItemCarrinho(1, 9.99,"mouse") )
            tvQuantidadeMouse.text = carrinho.getQuantidadeItem(mouse).toString()
        }
        btnMenosMouse.setOnClickListener {
            carrinho.removerItem( ItemCarrinho(1, 9.99,"mouse") )
            tvQuantidadeMouse.text = carrinho.getQuantidadeItem(mouse).toString()
        }

        btnMaisTeclado.setOnClickListener {
            carrinho.adicionarItem( ItemCarrinho(1, 39.50,"teclado") )
            tvQuantidadeTeclado.text = carrinho.getQuantidadeItem(teclado).toString()
        }
        btnMenosTeclado.setOnClickListener {
            carrinho.removerItem( ItemCarrinho(1, 39.50,"teclado") )
            tvQuantidadeTeclado.text = carrinho.getQuantidadeItem(teclado).toString()
        }

        fechar.setOnClickListener {
            tvFechado.text = "Preço final R$: ${ "%.2f".format(carrinho.valorTotal) }"
        }
    }

    // Inicializa os objetos de view
    private fun setupViews() {
        tvMouse = findViewById(R.id.tv_mouse)
        tvQuantidadeMouse = findViewById(R.id.tv_quantidade_mouse)
        btnMaisMouse = findViewById(R.id.btn_mais_mouse)
        btnMenosMouse = findViewById(R.id.btn_menos_mouse)

        tvTeclado = findViewById(R.id.tv_teclado)
        tvQuantidadeTeclado = findViewById(R.id.tv_quantidade_teclado)
        btnMaisTeclado = findViewById(R.id.btn_mais_teclado)
        btnMenosTeclado = findViewById(R.id.btn_menos_teclado)

        fechar = findViewById(R.id.fechar)
        tvFechado = findViewById(R.id.tv_fechado)
    }

}