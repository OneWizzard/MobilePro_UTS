package com.application.uts.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.application.uts.Adapter.BeritaAdapter
import com.application.uts.Data.Berita
import com.application.uts.DetailBerita
import com.application.uts.R
import com.application.uts.databinding.FragmentNewsBinding


class FragmentNews : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var beritaArraylist : ArrayList<Berita>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for the fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        // Initialize the data
        val imageId = intArrayOf(
            R.drawable.ukt,
            R.drawable.starlink,
            R.drawable.tsunami,
            R.drawable.shani,
            R.drawable.malas,
            R.drawable.sendok,
            R.drawable.luhut,
            R.drawable.vatikan,
            R.drawable.santo,
            R.drawable.gunung
        )

        val title = arrayOf(
            "Aduan BEM ke DPR Soal UKT Naik 8 Kali",
            "Starlink Resmi Diluncurkan di RI Hari ini",
            "BMKG Antisipasi 'Kiamat' Megathrust, Investigasi Dimulai dari Batam",
            "Selamat, Shani Ditunjuk Jadi Wakil GM dan Gracia Jadi Kapten JKT48",
            "3 Tanda Rasa Bosan Terhadap Rutinitas Sudah Mencapai Batasnya",
            "Mengenal Spoon Theory, Alokasikan Energimu dengan Tepat!",
            "Luhut Tepis Anggapan Asing soal Indonesia Tidak Peduli Lingkungan",
            "Vatikan Perketat Aturan Fenomena Supernatural untuk Lawan Hoaks",
            "Kisah Santo Suruh, Buka Jasa Buat Disuruh-Suruh Apa Saja",
            "Cek Fakta: Pulau Tagulandang Akan Tenggelam Usai Erupsi Gunung Ruang?"
        )

        val desc = arrayOf(
            "Aliansi Badan Eksekutif Mahasiswa Seluruh Indonesia (BEM SI) mengadukan kenaikan Uang Kuliah Tunggal (UKT) hingga 500% di beberapa universitas negeri ke Komisi X DPR RI. Aduan ini direspons dan berakhir pemanggilan terhadap Mendikbudristek Nadiem Makarim. Perwakilan BEM SI dari Unsoed, Maulana Ihsan Huda, menyebut kenaikan UKT berkisar 300-500%. Maulana menyebut para mahasiswa sempat melakukan audiensi dengan rektorat namun berujung nihil.\n\"UKT di Universitas Jenderal Soedirman ini naik melambung sangat jauh. Kenaikan bisa 300 sampai 500 persen,\" ujar Maulana dalam rapat dengan Komisi X DPR, Kamis.\n" ,
            "Layanan internet satelit Starlink bakal resmi diluncurkan di Indonesia dari Bali, Minggu (19/5), oleh bos SpaceX, miliarder AS Elon Musk.\n \"Hadir, hadir. Elon musk hadir besok meresmikan Starlink di satu puskesmas di Denpasar. Kemudian, tanggal 20 Elon Musk ini akan speech di pembukaan KTT World Water Forum ke-10,\" kata Direktur Jenderal Informasi Komunikasi Publik (IKP) Kominfo Usman Kansong, di sela Balinese Water Purification Ceremony membuka rangkaian WWF ke-10 di Kawasan Kura Kura Bali, Denpasar, Sabtu 18/5).\n",
            "Badan Meteorologi, Klimatologi, dan Geofisika (BMKG) mulai mempersiapkan ekspedisi investigasi fenomena kegempaan yang ada pada zona megathrust di Indonesia. Hal ini untuk mengantisipasi teror gempa megathrust yang bisa menjadi pemicu tsunami dahsyat dari pulau Sumatera hingga Sulawesi.\n",
            "Ada kejutan dari event Personal Meet and Greet Festival Spring Has Come! JKT48. Shani yang beberapa waktu lalu telah resmi graduate sebagai member JKT48, diumumkan menjadi wakil General Manager alias GM Theater.Dibacakan langsung oleh GM Theater JKT48 saat ini, Melody, pengumuman Shani menjadi wakil GM Theater ini disambut sorak riang tak hanya dari member tapi juga para fans yang hadir. \"Sekarang mungkin sudah saatnya aku membantu JKT48 dari internalnya. Pokoknya sampai kapan pun kalau JKT48 butuh bantuan pasti aku akan sangat senang sekali membantu. Jadi untuk semuanya juga, mohon bantuannya,\" ujar Shani setelah secara resmi diumumkan sebagai wakil GM Theater.\n",
            "Rutinitas harian yang monoton dapat menyebabkan kejenuhan dan burnout.\n Ketika kebosanan terhadap rutinitas mencapai batasnya, aktivitas menjadi sulit dan motivasi menurun. Perlu mencari kesempatan untuk istirahat, ciptakan waktu senggang, dan melakoni aktivitas yang menciptakan kegembiraan.",
            "Setiap manusia membutuhkan energi untuk bisa beraktivitas. Energi ini bisa berbeda-beda setiap orangnya, bahkan setiap waktunya. Ada kalanya kamu merasa banyak energi untuk melakukan banyak aktivitas, namun ada juga waktu dimana kamu benar-benar merasa seperti kehilangan energi.Kasus lainnya, kamu mungkin sangat bersemangat di awal hari, namun belum usai hari, energi kita sudah terlanjur habis. Alhasil, kegiatan di akhir waktu gak sanggup kamu lewati. Bisa jadi kamu terlalu memaksakan diri, sehingga berujung dengan terkapar sakit karena kelelahan. Sebenarnya, dengan mengerti kapasitas energi kita di awal hari, kita bisa mengatur alokasi energi kita dalam sehari tersebut.\n",
            "Menteri Koordinator Bidang Maritim dan Investasi Luhut Binsar Pandjaitan membantah pandangan asing yang menilai Indonesia tidak peduli dengan lingkungan. Luhut  menegaskan bahwa pelaksanaan upacara Segara Kerthi merupakan wujud komitmen Indonesia menjaga alam.“Beberapa orang asing berpikir kami (Indonesia) tidak peduli tentang lingkungan,” ujar Luhut ketika memberi sambutan dalam upacara Segara Kerthi yang digelar di Bali, Sabtu (18/5/2024), dilansir ANTARA.\n",
            "Vatikan mengubah proses evaluasi fenomena supernatural\n Hanya Paus yang berwenang menyatakan penampakan atau wahyu sebagai supernatural\n Vatikan menawarkan enam kemungkinan kesimpulan dalam menyelidiki fenomena tersebut\n",
            "Di tengah banyaknya berbagai profesi yang ada saat ini, seorang pria asal Pondok Gede, Bekasi, viral karena membuka jasa yang berbeda dari biasanya. Santo yang dikenal dengan jasa Santo Suruh membuka jasa pelayanan sebagai orang suruhan yang bisa dimintai mengerjakan apa saja.Dilihat dari akun media sosialnya, Santo Suruh sudah memberikan jasa sejak 2019. Dia mengerjakan berbagai permintaan pelanggan contohnya seperti belanja, membereskan rumah, hingga membuang kotoran kucing. Santo menjajakan dirinya sebagai orang suruhan.Dia mau mengantarkan barang, membeli sesuatu, beberes rumah, membersihkan pintu ruko hingga menarik uang di ATM.",
            "Ribuan warga dievakuasi dari Pulau Tagulandang akibat erupsi Gunung Ruang di Sulawesi Utara. Badan Geologi membantah narasi tenggelamnya pulau tersebut, dengan demikian kabar Pulau Tagulandang akan tenggelam tidaklah benar. \n"
        )

        beritaArraylist = ArrayList()
        for (i in imageId.indices) {
            val berita = Berita(title[i], desc[i], imageId[i])
            beritaArraylist.add(berita)
        }

        // Set the adapter for the ListView
        binding.listView.isClickable = true
        binding.listView.adapter = BeritaAdapter(requireActivity(), beritaArraylist)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val title = title[position]
            val desc = desc[position]
            val imageId = imageId[position]

            val i = Intent(requireActivity(), DetailBerita::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", desc)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }

        // Return the root view of the fragment
        return binding.root
    }
}