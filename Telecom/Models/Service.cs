using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class Service
    {
        private int id;
        private string serviceName;
        private string content;
        private double price;

        public Service()
        {
        }

        public Service(string serviceName, string content, double price)
        {
            this.serviceName = serviceName;
            this.content = content;
            this.price = price;
        }

        public int Id { get => id; set => id = value; }
        public string ServiceName { get => serviceName; set => serviceName = value; }
        public double Price { get => price; set => price = value; }
        public string Content { get => content; set => content = value; }
    }
}