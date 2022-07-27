<center>
<img src="https://github.com/Biniobiniasty/CryptoAnalizer/blob/master/screenshoot/2.png" height="350" width="800"/>
 
 <b>CryptoAnalizer</b> - Consists of two modules (Harvester and Analyzer)<br />
 The program downloads data from publicly available Internet sources and displays them in one place. It analyzes the collected data and displays various information.
 <br /><br />
Due to the differences in sources, each source is analyzed by an individual implementation. If the source code changes and the program doesn't read the information correctly, it will either take zero or discard the data it doesn't take into account.
 <br /><br />

<table>
<tr><td>
 <img src="https://github.com/Biniobiniasty/CryptoAnalizer/blob/master/screenshoot/1.png" height="300" width="200"/></td>
 <td>
  <b>HARVESTER</b><br />
  This module runs on eight threads, each thread is responsible for retrieving data from the source, validating the data and sending it to the Analyzer.
  <br /><br />
  <b>Descriptions:</b>
  <ul>
   <li>Progress bars indicate the thread is working.</li>
   <li>From the list you can choose the time interval the program should download data from sources.</li>
   <li>Labels display data on the time elapsed since the data was downloaded and the multiple of downloads.</li>
  </ul>
  
 </td></tr>
 <tr><td>
 <img src="https://github.com/Biniobiniasty/CryptoAnalizer/blob/master/screenshoot/3.png" height="250" width="800"/>
</td><td>
  <b>ANALIZER</b><br />
  This module waits for data from Harvester, after receiving the data, it displays it, performs analysis and displays the results in the window on the right.
  <br /><br />
  <b>Descriptions:</b>
  <ul>
   <li>The window on the left displays the collected data</li>
   <li>The drop-down list allows you to select the source to be displayed.</li>
   <li>The window on the right shows the results of the data analysis.</li>
  </ul>
</td></tr>
 </table>

</center>
