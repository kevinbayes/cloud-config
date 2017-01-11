using System;
using Steeltoe.Extensions.Configuration;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Hosting.Internal;
using Microsoft.Extensions.Configuration;
using System.IO;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {

            IHostingEnvironment env = new HostingEnvironment();

            var builder = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json")
            .AddEnvironmentVariables()                   
            .AddConfigServer(env);

            var config = builder.Build();

            
            Console.WriteLine($"{config["message"]}");

        }
    }
}
